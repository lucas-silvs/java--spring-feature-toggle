import axios from "axios";
import { useState } from "react";

export default function FlagList() {
  const [flaglist, setFlagList] = useState([]);

  return (
    <div className="FlagList">
      <input type="text" /> <button onClick={atualizar}> Atualizar </button>
      <ul>
        {flaglist.length > 0 &&
          flaglist.map((item: any) => (
            <li key={item.uid + item.group}>
              flag: {item.uid} - group: {item.group} - status:{" "}
              {String(item.enable)}
            </li>
          ))}
      </ul>
    </div>
  );

  async function atualizar() {
    const url = "http://localhost:5000/feature--toggle/api/ff4j/store/features";
    let tempLista = flaglist;
    try {
      const result = await axios.get(url, {
        auth: {
          username: "teste",
          password: "teste",
        },
      });
      setFlagList(result.data);
      console.log(flaglist);
    } catch (error) {
      console.log("deu erro meu nobrer: " + error);
    }
  }
}
