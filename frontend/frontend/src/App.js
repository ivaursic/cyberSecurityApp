import logo from './logo.svg';
import './App.css';
import LoginPage from './components/LoginPage';
import Header from './components/Header';
import { Dashboard } from '@mui/icons-material';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <>
    <Header/>
    <BrowserRouter>
            <Routes>
                <Route exact path="/" component={Dashboard} />
                <Route exact path="/login" component={LoginPage} />
            </Routes>
        </BrowserRouter>
        </>

  );
}

export default App;
