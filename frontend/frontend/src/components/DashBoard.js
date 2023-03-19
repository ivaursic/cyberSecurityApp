import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import MyAlerts from "./MyAlerts";
import { Card } from "@mui/material";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";
import { CategoryScale, LinearScale, BarElement, Title } from "chart.js";
import { Pie } from "react-chartjs-2";
import { Bar } from "react-chartjs-2";
import { faker } from "@faker-js/faker";
import { CenterFocusStrong } from "@mui/icons-material";
import "../App.css";

ChartJS.register(ArcElement, Tooltip, Legend);

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: "top",
    },
    title: {
      display: true,
      text: "Chart.js Bar Chart",
    },
  },
};

const labels = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];

export const dataChart = {
  labels,
  datasets: [
    {
      label: "High Alert",
      data: labels.map(() => faker.datatype.number({ min: 0, max: 1000 })),
      backgroundColor: "rgba(232, 9, 9, 1)",
    },
    {
      label: "Medium Alert",
      data: labels.map(() => faker.datatype.number({ min: 0, max: 1000 })),
      backgroundColor: "rgba(255, 128, 0, 1)",
    },
    {
      label: "Low Alert",
      data: labels.map(() => faker.datatype.number({ min: 0, max: 1000 })),
      backgroundColor: "rgba(255, 255, 28, 1)",
    },
  ],
};

export function Dashboard() {
  var user = JSON.parse(localStorage.getItem("user"));
  const token =
    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWNpamEuZG9taWNAZmVyLmhyIiwiZXhwIjoxNjc5MTk2MzU4LCJpYXQiOjE2NzkxOTI3NTh9.YQN237WbifZbGgmW6BVa8SPJnDMwOHwtjh-1mXHpZaic5efkwBA2hVUwo-v6qvXRIZS-Btg8w_9tbWnITyLm6A";

  const config = {
    headers: { Authorization: `Bearer ${token}` },
  };

//  const [numberOfHigh, setNumberOfHigh] = React.useState([]);
//  const [numberOfMedium, setNumberOfMedium] = React.useState([]);
//  const [numberOfLow, setNumberOfLow] = React.useState([]);

  const dataPie = {
    labels: ["High Alert", "Medium Alert", "Low Alert"],
    datasets: [
      { 
        label: '# of Alerts',
        data: [5, 7, 15],
        backgroundColor: [
          "rgba(232, 9, 9, 1)",
          "rgba(255, 128, 0, 1)",
          "rgba(255, 255, 28, 1)",
        ],
        borderColor: [
          "rgba(0, 0, 0, 1)",
          "rgba(0, 0, 0, 1)",
          "rgba(0, 0, 0, 1)",
        ],
        borderWidth: 1,
      },
    ],
  };

/*  React.useEffect(() => {
    axios
      .get(`http://localhost:8080/getNumberOfHigh`, config)
      .then((response) => {
        setNumberOfHigh(response.data);
        console.log(response.data);
      });
  }, []);

  React.useEffect(() => {
    axios
      .get(`http://localhost:8080/getNumberOfMedium`, config)
      .then((response) => {
        setNumberOfMedium(response.data);
      });
  }, []);

  React.useEffect(() => {
    axios
      .get(`http://localhost:8080/getNumberOfLow`, config)
      .then((response) => {
        setNumberOfLow(response.data);
      });
  }, []); */

  return (
    <>
    {user !== null &&
    <div className="dashboard">
      <div className="alerts-card ">
        <div className="styleCard">
          <MyAlerts />
        </div>
        <div class="row">
          <div className="styleCard">
            <div className="pie">
              <Pie data={dataPie} />
            </div>
          </div>
          <div className="styleCard">
            <Bar options={options} data={dataChart} />
          </div>
        </div>
      </div>
      <div className="card"></div>
    </div>
    }
    </>
  );
}
