import logo from "./logo.svg";
import "./App.css";
import LoginPage from "./components/LoginPage";
import Header from "./components/Header";
import Registration from "./components/Registration";
import { Dashboard } from './components/DashBoard';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MyAlert from "./components/MyAlert";
import Alerts from "./components/MyAlerts";

function App() {
  return (
    <>
      <Header />
      <>
        <MyAlert></MyAlert>
      </>
      <Routes>
        <Route exact path="/" element={<Dashboard></Dashboard>} />
        <Route exact path="/login" element={<LoginPage></LoginPage>} />
        <Route
          exact
          path="/registration"
          element={<Registration></Registration>}
        />
      </Routes>
    </>
  );
}

export default App;
