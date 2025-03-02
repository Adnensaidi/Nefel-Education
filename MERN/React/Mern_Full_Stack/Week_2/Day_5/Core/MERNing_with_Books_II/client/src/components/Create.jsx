import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"

export default function Create() {
    const [book,setBook] = useState({
        title:"",
        author:"",
        pagesCount:0,
        available:false
    })
    const navigate = useNavigate();
    const handleChange =(e)=>{
        setBook({
            ...book,
            [e.target.name]:isNaN(e.target.value||e.target.checked)?e.target.value:parseInt(e.target.value)
        })
    }
    const handleChecked = ()=>{
        setBook((b)=>{return {...b,available:!b.available}})
    }
    useEffect(()=>{
        console.log(book);
    },[book])
    const addBook = async (e)=>{
        e.preventDefault();
        try {
            const result = await axios.post(`http://localhost:3000/book/`,book);
            console.log(result);
            setBook(result.data);
            navigate("/")
        } catch (error) {
            console.log(error);
        }
    }
  return (
    <main className="d-flex flex-row justify-content-center align-items-center min-vw-100 min-vh-100">
        <form onSubmit={addBook} className="card w-50 max-vw-75 p-3">
            <div className="form-group">
                <label htmlFor="title" className="form-label">title</label>
                <input type="text" onChange={(e)=>handleChange(e)} name="title" value={book.title} id="title" className="form-control" />
            </div>
            <div className="form-group">
                <label htmlFor="author" className="form-label">author</label>
                <input type="text" onChange={(e)=>handleChange(e)} name="author" value={book.author} id="author" className="form-control" />
            </div>
            <div className="form-group">
                <label htmlFor="pagesCount" className="form-label">pagesCount</label>
                <input type="number" onChange={(e)=>handleChange(e)} name="pagesCount" value={book.pagesCount} id="pagesCount" className="form-control" />
            </div>
            <div className="form-group d-flex flex-row justify-content-start align-items-center gap-2">
                <input type="checkbox" onChange={()=>handleChecked()} name="available" checked={book.available} id="available" />
                <label htmlFor="available" className="form-label">available</label>
            </div>
            <button className="btn btn-primary">add book</button>
        </form>
    </main>
  )
}
