import "./Botao.css";

interface ConfiguracoesBotao {
  textoBotao: string;
}

export default function Botao(props: ConfiguracoesBotao) {
  return (
    <button type="submit" className="Botao">
      {props.textoBotao}
    </button>
  );
}
