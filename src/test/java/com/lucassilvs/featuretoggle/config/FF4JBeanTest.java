package com.lucassilvs.featuretoggle.config;

import org.ff4j.FF4j;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.web.taglib.FeatureTagEnable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.tagext.Tag;

import static org.ff4j.web.bean.WebConstants.FF4J_SESSIONATTRIBUTE_NAME;
import static org.mockito.Mockito.never;

class FF4JBeanTest {

    public static final String FEATURE_TESTE = "feature-teste";
    private FF4j ff4j;

    private FeatureTagEnable featureTagEnable;


    @BeforeEach
    private void setUp() {
        ff4j = Mockito.spy(new FF4j());

        ff4j.createFeature(FEATURE_TESTE);
        ff4j.enable(FEATURE_TESTE);

        MockPageContext pageContext = new MockPageContext();
        pageContext.setAttribute(FF4J_SESSIONATTRIBUTE_NAME, ff4j);
        ((MockHttpServletRequest) pageContext.getRequest()).setLocalName("localhost");

        featureTagEnable = new FeatureTagEnable();
        featureTagEnable.setPageContext(pageContext);
        featureTagEnable.setFeatureid(FEATURE_TESTE);
        featureTagEnable.setShareHttpSession(false);
    }

    @Test
    void it_should_render_feature_using_current_execution_context() throws Exception {
        FlippingExecutionContext executionContext = ff4j.getCurrentContext();

        int result = featureTagEnable.doStartTag();

        Assertions.assertEquals(Tag.EVAL_BODY_INCLUDE, result);
        Assertions.assertSame(executionContext, ff4j.getCurrentContext());
        Mockito.verify(ff4j).check(FEATURE_TESTE, executionContext);
    }

    @Test
    void it_should_render_feature_using_new_execution_context_because_of_http_session_sharing() throws Exception {
        FlippingExecutionContext executionContext = ff4j.getCurrentContext();

        featureTagEnable.setShareHttpSession(true);
        int result = featureTagEnable.doStartTag();

        Assertions.assertEquals(Tag.EVAL_BODY_INCLUDE, result);
        Assertions.assertSame(executionContext, ff4j.getCurrentContext());
        Mockito.verify(ff4j, never()).check(FEATURE_TESTE, executionContext);

        ArgumentCaptor<FlippingExecutionContext> argContext = ArgumentCaptor.forClass(FlippingExecutionContext.class);
        Mockito.verify(ff4j).check(Mockito.eq(FEATURE_TESTE), argContext.capture());

        FlippingExecutionContext localExecutionContext = argContext.getValue();
        Assertions.assertFalse(localExecutionContext.isEmpty());
        Assertions.assertEquals("localhost", localExecutionContext.getString("LOCALE"));
    }

}