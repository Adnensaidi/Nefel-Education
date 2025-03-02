import React,{useState,useEffect} from 'react'
import axios from 'axios'

function AllPost() {
    const [posts , setpost]=useState([])

    const getAllPosts = ()=>{
        axios.get("http://localhost:3000/api/posts/getAll")
        .then((res)=>{
            console.log(res.data)
        setpost(res.data)
        })
        useEffect
    }
    return (
        <div>AllPost</div>
    )
}

export default AllPost