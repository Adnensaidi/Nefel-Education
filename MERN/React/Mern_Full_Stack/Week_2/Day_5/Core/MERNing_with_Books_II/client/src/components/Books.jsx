import { useEffect, useState } from "react"
import axios from "axios"
import { Link } from "react-router-dom";
export default function Books() {
    const [books,setBooks] = useState([]);
    const getBooks = async ()=>{
        try {
            const result = await axios.get("http://localhost:3000/book");
            console.log(result);
            setBooks(result.data);
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(()=>{
        getBooks()
    },[])
    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>title</th>
                    <th>author</th>
                    <th>pages count</th>
                    <th>available</th>
                    <th>book page</th>
                </tr>
            </thead>
            <tbody>
                {
                    books.map((item,idx)=>(
                        <tr key={idx}>
                            <td>{item.title}</td>
                            <td>{item.author}</td>
                            <td>{item.pagesCount}</td>
                            <td className={`${item.available?'text-success':'text-danger'}`}>{item.available?"Yes":"no"}</td>
                            <td>
                                <button className="btn btn-success">
                                    <Link to={`/book/${item._id}`} className="text-light text-decoration-none">
                                        View info
                                    </Link>
                                </button>
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    )
}
