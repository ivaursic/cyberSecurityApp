import React from "react";
import Avatar from "@mui/material/Avatar";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import axios from 'axios';
import { Button } from "@mui/material";
import { ReactDOM } from "react";
import { Navigate, Router } from "react-router-dom";

export default function Registration() {

  const [firstName, setFirstName] = React.useState('');
  const [mail, setMail] = React.useState('');
  const [lastName, setLastName] = React.useState('');
  const [password, setPassword] = React.useState('');
  const [registered, setRegistered] = React.useState(false);
  const [user, setUser] = React.useState('');
  const [token, setToken] = React.useState('');

  async function handleSubmit(e) {
    e.preventDefault();
    const data = {
    mail : mail,
    password : password,
    firstName : firstName,
    lastName : lastName
  }

  try{
    axios.post("http://localhost:8080/registerUser", data)
    .then(function(res) {
      setUser(res.data);
      localStorage.setItem('user', JSON.stringify(res.data)); 
      const tokenData = {
        mail : res.data.mail,
        password : password
      }
      axios.post(
        "http://localhost:8080/authenticate", tokenData
      ).then(function(response)  {
        console.log(response.data);
        setToken(response.data);
        localStorage.setItem('token', JSON.stringify(response.data));
      });
      setRegistered(true);
    }).catch( function(error) {
      console.log(error);
      alert('Something went wrong');
    });
  } catch (error) {
    console.log(error);
  }

  
  };

  if(registered){
    return <Navigate to='/dashboard'></Navigate>
  }

  return (
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
        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="name"
            label="Name"
            name="name"
            autoComplete="name"
            autoFocus
            onChange={({ target }) => setFirstName(target.value)}
          />
          <TextField
            margin="normal"
            required
            fullWidth
            id="surname"
            label="Surname"
            name="surname"
            autoComplete="surname"
            autoFocus
            onChange={({ target }) => setLastName(target.value)}
          />
          <TextField
            margin="normal"
            required
            fullWidth
            id="email"
            label="Email Address"
            name="email"
            autoComplete="email"
            autoFocus
            onChange={({ target }) => setMail(target.value)}
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
            onChange={({ target }) => setPassword(target.value)}
          />
          <Button
          onSubmit = {handleSubmit}
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}>
              Sign In
            </Button>
        </Box>
      </Box>
    </Container>
  );
}
