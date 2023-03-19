import MyAlert from './MyAlert';
import React from 'react';

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

    /*React.useEffect(() => {
        fetch('./data/threatInfo.json').then(alerts => alerts.json())
        .then(alerts => setAlerts(alerts))
        .then(console.log(alerts));
    }, []);*/

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
