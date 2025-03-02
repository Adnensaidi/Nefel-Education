import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"

export default function BookDetails() {
    const  {id} = useParams();
    const [book,setBook] = useState({});
    const navigate = useNavigate()
    const [error,setError] = useState("")
    const getBook = async ()=>{
        try {
            const result = await axios.get(`http://localhost:3000/book/${id}`);
            console.log(result);
            setBook(result.data);
        } catch (error) {
            console.log(error);
        }
    }
    const handelDelete =async()=>{
        try {
            const request = await axios.delete(`http://localhost:3000/book/${id}`);
            if(request.status == 200){
                navigate("/");
            }else{
                setError("error removing the book")
            }
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(()=>{
        getBook()
    },[])
    return (
    <main className="d-flex flex-row justify-content-center align-items-center min-vw-100 min-vh-100">
        {
            book?(
                <div className="card w-50 max-vw-75">
                    <div className="card-header">
                        <p>{book.title}</p>
                        <p>{book.author}</p>
                    </div>
                    <div className="card-body">
                        <p>{book.pagesCount}</p>
                        <p className={book.available?"text-success":"text-danger"}>{book.available?"available":"not yet"}</p>
                    </div>
                    <div className="card-footer d-flex justify-content-center">
                        <button onClick={handelDelete} className="btn btn-danger">Borrow</button>
                    </div>
                </div>
            ):(
                <div className="alert alert-danger">book with {id} not found</div>
            )
        }
        {
            error && (
                <p>
                    {error}
                </p>
            )
        }
    </main>
  )
}
