import MyAlert from './MyAlert';
import React from 'react';

import axios from 'axios';

export default function MyAlerts() {

    //const [alerts , setAlerts] = React.useState([]);

    const alerts = [ 
            {
                "severity" : "error",
                "type" : "virus",
                "source" : "ip",
                "potentialImpact" : "databaseBreach"
            },
            {
                "severity" : "warning",
                "type" : "virus",
                "source" : "ip2",
                "potentialImpact" : "server shutdown"
            },
            {
                "severity" : "info",
                "type" : "data leaked",
                "source" : "ip",
                "potentialImpact" : "databaseBreach"
            },
            {
                "severity" : "error",
                "type" : "virus",
                "source" : "ip",
                "potentialImpact" : "databaseBreach"
            },            {
                "severity" : "error",
                "type" : "virus",
                "source" : "ip",
                "potentialImpact" : "databaseBreach"
            },            {
                "severity" : "error",
                "type" : "virus",
                "source" : "ip",
                "potentialImpact" : "databaseBreach"
            },
        
    ];

    //var user = JSON.parse(localStorage.getItem('user'));

    /*React.useEffect(async () => {
        const token = await JSON.parse(localStorage.getItem('token'));
        console.log(token.token);
        const config= {
            headers: { Authorization : `Bearer ${token.token}`}
        }

        const response = await axios.get('http://localhost:8080/getAllAlerts', config).then(alerts => alerts.json())
        .then(alerts => setAlerts(alerts))
        .then(console.log(alerts));
     });*/
    //const token = JSON.parse(localStorage.getItem('token'));

    


    return (
        <>
            <div>
                <h3>There are potential threats to the network :</h3>
                {alerts.map(alert => 
                <MyAlert severity= {alert.severity}
                type= {alert.type}
                source= {alert.source}
                potentialImpact= {alert.potentialImpact}>
                </MyAlert>
            
                    )};
            </div>
        </>
    );
}
