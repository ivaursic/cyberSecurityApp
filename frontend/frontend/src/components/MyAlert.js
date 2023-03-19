import { Alert } from "@mui/material";
import React, { useState } from "react";
import Button from "react-bootstrap/Button";

export default function MyAlert() {
  const [show, setShow] = useState(true);

  if (show) {
    return (
      <>
        <Alert
          severity="warning"
          className="styleCard"
          onClose={() => setShow(false)}>
          {" "}
          Hello :
        </Alert>
      </>
    );
  }
  return <Button onClick={() => setShow(true)}>Show Alert</Button>;
}
