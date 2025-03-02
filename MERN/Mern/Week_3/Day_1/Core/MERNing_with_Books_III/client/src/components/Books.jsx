import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Home = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        const fetchBooks = async () => {
            const response = await axios.get('/api/books');
            setBooks(response.data);
        };
        fetchBooks();
    }, []);

    return (
        <div>
            <h2>Books</h2>
            <ul>
                {books.map((book) => (
                    <li key={book._id}>
                        {book.title} by {book.author} - {book.pageCount} pages
                        <Link to={`/update/${book._id}`}> Update</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Home;
