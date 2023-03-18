import { Alert, AlertTitle } from "@mui/material";
import React from "react";

export default function MyAlert(props) {

    const {severity, source, type, potentialImpact} = props.alert;
    return (
        <>
            <Alert severity={severity}> 
            <AlertTitle>{type}</AlertTitle>
            source : {source}, 
            potenital impact: {potentialImpact}
            </Alert>
        </>
    );
}