import { useState } from 'react';
import {useParams} from 'react-router-dom'

function BoardDetail() {
    // const [bno, setBno] = useState(0);

    const params = useParams();
    console.log(params.bno);
    // setBno(params.bno);

    return (
        <div className="container main">
            <h1>boardDetail{params.bno}</h1>
        </div>
    );
}

export default BoardDetail;