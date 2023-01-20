import "./CampoTexto.css";

interface ConfiguracoesCampoTexto {
  tipo: string;
  textoLabel: string;
  setValor: React.Dispatch<React.SetStateAction<string>>;
}

export default function CampoTexto(props: ConfiguracoesCampoTexto) {
  return (
    <div className="CampoTexto">
      <label>{props.textoLabel}</label>
      <input
        type={props.tipo}
        onChange={(e) => props.setValor(e.target.value)}
      ></input>
    </div>
  );
}
