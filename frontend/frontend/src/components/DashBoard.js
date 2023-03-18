import MyAlerts from "./MyAlerts";
import '../styles/DashboardCard.css';
import { Card } from "@mui/material";


export function Dashboard() {
    return (

        <div className="dashboard">
        <div className="alerts-card">
        <MyAlerts/>
        </div>
        <div className="card">

        </div>
        </div>
    );
}