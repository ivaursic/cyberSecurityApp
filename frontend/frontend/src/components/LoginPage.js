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
import { Navigate, useNavigate } from "react-router-dom";

import axios from 'axios';

function Copyright(props) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}>
      {"Copyright © "}
      <Link color="inherit" href="https://mui.com/">
        Your Website
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

const theme = createTheme();

export default function LoginPage() {


  const [data, setData] = React.useState({
    mail : '',
    password : ''
  });

  const [error, setError] = React.useState('');
  const [email, setEmail] = React.useState("");
  const [formPassword, setFormPassword] = React.useState("");
  const [userL, setUserL] = React.useState("");
  const [logged, setLogged] = React.useState(false);
  const url = 'http://localhost:8080/login';



    // function routeChange() {
    //   return <Navigate to='/dashboard'></Navigate>
    // }

  async function handleSubmit(e) {

    let config = {
      headers : {
        'Content-Type': 'application/json',
        'Authorization': null,
      }
    }

    const axiosPayload = {
      mail: email,
      password: formPassword
    }

    e.preventDefault();
    const response = await axios.post("http://localhost:8080/login", axiosPayload
    ).then(res => {
      setUserL(res.data);
      setLogged(true);
      console.log(res.data);
      
      return <Navigate to='/dashboard'></Navigate>
    }).catch(err => {
      console.log(err);
    });
  };

  if(logged){
    return <Navigate to='/confirmLogin'></Navigate>
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
            Sign in
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
              id="email"
              label="Email Address"
              name="email"
              autoComplete="email"
              autoFocus
              onChange={({ target }) => setEmail(target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
              onChange={({ target }) => setFormPassword(target.value)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}>
              Sign In
            </Button>
            <Grid container>
              <Grid item>
                <Link href="/registration" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
    </ThemeProvider>
  );
}