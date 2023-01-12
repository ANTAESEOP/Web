import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios'; //


export default function Signup( props ) {

    const setmember = () => {

        let info = {
            mid : document.querySelector('.mid').value,
            mpassword : document.querySelector('.mpassword').value,
            mname : document.querySelector('.mname').value,
            mphone : document.querySelector('.mphone').value
        }

        axios
            .post("/member/setmember" , info )
            .then( res => {
                let result = res.data;
                if( result != 0 ){
                    alert('회원가입 완료')
                } else {
                    alert('회원가입 실패')
                }
            })
            .catch( err => { alert( err ) } )
        }

    return(
        <div className="container">
            <Form>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Email</Form.Label>
                <Form.Control type="text" placeholder="아이디" className="mid"/>
                <Form.Text className="text-muted">
                    회원님의 이메일을 다른 누구와도 공유하지 않습니다.
                </Form.Text>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="text" placeholder="비밀번호" className="mpassword"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" placeholder="이름" className="mname"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Phone</Form.Label>
                <Form.Control type="text" placeholder="전화번호" className="mphone"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="동의" />
              </Form.Group>
              <Button variant="primary" type="submit" onClick={ setmember }>
                회원가입
              </Button>
            </Form>
        </div>
    );
}