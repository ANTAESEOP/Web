import React from 'react';
import { HashRouter, BrowserRouter, Routes, Route, Link, Router } from "react-router-dom"; // 라우터 설치

export default function Header( props ){

    return(

        <div className="option">
            <ul>
                <li> <Link to="/"> Main </Link> </li>
                <li> <Link to="/member/signup"> 회원가입 </Link> </li>
                <li> <Link to="/member/login"> 로그인 </Link> </li>
                <li> <Link to="/board/write"> 글 작성 </Link> </li>
                <li> <Link to="/board/list"> 글 리스트 </Link> </li>
                <li> <a href="/member/logout"> Logout </a> </li>
            </ul>
        </div>
    )
}