import React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { Navigate } from "react-router-dom";
import axios from 'axios';



const theme = createTheme();

export default function ConfirmLogin() {

    var user = JSON.parse(localStorage.getItem('user'));
   

    const [code, setCode] = React.useState('');
    const [insert, setInsert] = React.useState(false);

    if(insert){
      return <Navigate to='/dashboard'></Navigate>
    }

    async function handleSubmit() {
      setInsert(true);

       /*try{
        axios.post(`http://localhost:8080/confirmLogin/${user.idUserAccount}`, code, pConfig )
        .then( function(response) {
          console.log(response);
          setInsert(true);
        }
        )
       }  catch(e) {
        console.log(e);
        alert("Wrong code");
       }*/
    } 
  
    return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}>
          <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Please enter the verification code
          </Typography>
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="code"
              label="code"
              name="code"
              autoComplete="code"
              autoFocus
              onChange={({ target }) => setCode(target.value)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}>
              Confirm code
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}