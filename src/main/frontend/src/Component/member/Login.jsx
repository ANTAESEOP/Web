import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios'; //


export default function Login( props ) {
    const getmember = () => {

        let info = {
            mid : document.querySelector('.mid').value,
            mpassword : document.querySelector('.mpassword').value
        }

    axios
        .post("/member/getmember" , info)
        .then( res => {
            let result = res.data;
            if( result = 1 ){ alert( "로그인 완료" ) }
            else if( result = 2 ) { alert(" 로그인 실패 ") }
            else{ alert("계정을 확인해주세요") }
        })
        .catch( err => { alert( err ) } )
    }



    return(
        <div className="container">
            <Form>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Email</Form.Label>
                <Form.Control type="text" placeholder="아이디" className="mid"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="text" placeholder="비밀번호" className="mpassword"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="로그인 유지하기" />
              </Form.Group>
              <Button variant="primary" type="submit" onClick={ getmember }>
                로그인
              </Button>
            </Form>
        </div>
    )

}