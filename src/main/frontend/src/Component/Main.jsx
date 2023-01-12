import React, {useEffect, useState} from 'react';
import { HashRouter, BrowserRouter, Routes, Route, Link, Router } from "react-router-dom"; // 라우터 설치
import Style from '../css/Main.css'
import Footer from './Footer.jsx'
import Header from './Header.jsx'
import Signup from './member/Signup.jsx'

export default function Main( props ) {
    return(
        <div className="webbox">
            <BrowserRouter>
                <Header/>
                    <Routes>
                        <Route path="/" />
                        <Route path="/member/signup" element={ <Signup/> } />
                    </Routes>
                <Footer/>


            </BrowserRouter>
        </div>
    );
}