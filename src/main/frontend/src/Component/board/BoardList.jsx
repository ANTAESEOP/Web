import React , { useState , useEffect } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios'; //
import Style from '../../css/BoardWrite.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';


export default function BoardList( props ) {

    const [ BoardList , setBoardList ] = useState([])

    function getboardList(){ // 2. server : pageInfo 요청 =>  pageDto 응답 리스트를 가져오는 함수 [ 실행조건 : 1. 렌더링될때 2. 검색할때 3. 카테고리선택 4. 페이징선택 ---> 일반 함수화 ]
        axios
            .get('/board/getboard')
            .then( res => { setBoardList( res.data ); console.log( res.data ); } ) .catch( err => { console.log( err ); })
    }
    useEffect( getboardList , [ ] );

    return(
        <Table striped bordered hover size="sm">
            <thead>
                <tr>
                  <th> 글 번호 </th>
                  <th> 글 제목 </th>
                  <th> 글 내용 </th>
                </tr>
            </thead>

        {BoardList.map( ( b )=> {
            return(
                <>
                    <tbody>
                        <tr>
                            <td> { b.bno } </td>
                            <td> { b.btitle } </td>
                            <td> { b.bcontent } </td>
                        </tr>
                    </tbody>
                </>
            );
        })}
        </Table>
    );
}




