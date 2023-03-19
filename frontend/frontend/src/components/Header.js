import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import AccountCircle from '@mui/icons-material/AccountCircle';
import { Link } from 'react-router-dom';



export default function Header() {


    return (
        <Box sx={{ flexGrow: 1}}>
          <AppBar position="static">
            <Toolbar>
                  <Link to ='/login'>
                  <AccountCircle></AccountCircle>
                  </Link>
            </Toolbar>
          </AppBar>
        </Box>
      );
}