import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios'; //
import Style from '../../css/BoardWrite.css'

let bcontent = '';

export default function BoardWrite( props ) {

    const setboard = () => {

        let boardform = document.querySelector('.boardform')
        let formdata = new FormData(boardform);
        formdata.set( "bcontent" , bcontent );


    axios
        .post("/board/setboard" , formdata )
        .then( res => {
            let result = res.data;
            console.log(res.data)
            if( result != 0 ){ alert('글 작성 성공') }
            else { alert('글 작성 실패') }
        })
        .catch( err => { alert( err ) } )
    }

    return(
    <div>
        <form className="boardform">
            제목 : <input type ="text" Name="btitle" /> <br/>
             <CKEditor
                editor={ ClassicEditor }
                data="<p> 내용을 입력 해 주세요! </p>"
                onChange={ ( event, editor ) => { const data = editor.getData(); bcontent = data } }

            />
            <button type="button" onClick={ setboard }> 등록 </button>
        </form>
    </div>
    )
}