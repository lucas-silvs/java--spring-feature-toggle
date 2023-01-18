import axios from "axios";
import { useState } from "react";
import Botao from "./Botao";
import CampoTexto from "./CampoTexto";
import "./Login.css";

export function Login() {
  const [login, setLogin] = useState<string>("");
  const [senha, setSenha] = useState<string>("");

  async function handleValidarCredencial() {
    const url = "http://localhost:5000/feature--toggle/login";
    const body = {
      usuario: login,
      senha: senha,
    };
    try {
      const response = await axios.post(url, body, {
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (response.status === 200) {
        console.log("deu certinho :) ");
      } else {
        console.log("deu errinho '-' ");
      }
      console.log(response.status);
    } catch (error) {
      console.log("deu errinho '-' erro: " + error);
    }
  }
  const validarCredencial = (event: React.FormEvent<HTMLInputElement>) => {
    handleValidarCredencial();
    event.preventDefault();

    console.log("form submitted ✅");
  };

  return (
    <section className="Login" onSubmit={validarCredencial}>
      <form>
        <h2>Login</h2>

        <CampoTexto setValor={setLogin} tipo="text" textoLabel="Usuario" />
        <CampoTexto setValor={setSenha} tipo="password" textoLabel="Senha" />

        <Botao textoBotao="Login" />
      </form>
    </section>
  );
}
