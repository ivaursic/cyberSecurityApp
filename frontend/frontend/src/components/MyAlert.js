import { Alert } from "@mui/material";

export default function MyAlert({severity, type, source, potentialImpact}) {

   // const {severity, type, source, potentialImpact} = props.alert;

    //{props.alert.severity}! type: {props.alert.type}, source: {props.alert.source}, potential impact: {props.alert.potentialImpact}

    return (
        <>
            <Alert severity ={severity}> {severity}! type: {type}, source: {source}, potential impact: {potentialImpact}</Alert>
        </>
    );
}