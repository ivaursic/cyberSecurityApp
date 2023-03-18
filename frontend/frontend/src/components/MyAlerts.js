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
            }
        
    ];

    /*React.useEffect(() => {
        fetch('./data/threatInfo.json').then(alerts => alerts.json())
        .then(alerts => setAlerts(alerts))
        .then(console.log(alerts));
    }, []);*/

    return (
        <>
            <div>
                <h3>There are potenitals threats to the network :</h3>
                {alerts.map(alert => <MyAlert alert={alert}></MyAlert>)}
            </div>
        </>
    );
}
