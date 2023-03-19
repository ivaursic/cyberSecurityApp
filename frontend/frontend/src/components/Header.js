import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import AccountCircle from '@mui/icons-material/AccountCircle';
import { Link } from 'react-router-dom';
import { Logout } from '@mui/icons-material';



export default function Header() {

  var user = JSON.parse(localStorage.getItem('user'));
  const token = JSON.parse(localStorage.getItem('token'));

  function logout(){
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    window.location.reload(false);
  }


    return (
        <Box sx={{ flexGrow: 1}}>
          <AppBar position="static">
            <Toolbar>
              { user === null &&
              <Link to ='/login'>
              <AccountCircle></AccountCircle>
              </Link>}
              {user !== null &&
              <Link onClick={logout}>
              <Logout></Logout>
              </Link>
              }
              {
                user !== null &&
                <h1>Hello {user.firstName}</h1> 
              } 
              
              
            </Toolbar>
          </AppBar>
        </Box>
      );
}