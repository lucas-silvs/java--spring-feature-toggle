import { Routes, Route } from "react-router-dom";
import FlagList from "./pages/FlagList";
import { Login } from "./pages/Login";

export default function RouteIndex() {
  return (
    <Routes>
      <Route index element={<Login />} />
      <Route path="/flags" element={<FlagList />} />
    </Routes>
  );
}
