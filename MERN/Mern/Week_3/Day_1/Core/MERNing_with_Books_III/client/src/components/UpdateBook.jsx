import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useHistory } from 'react-router-dom';

const UpdateBook = () => {
    const { id } = useParams();
    const history = useHistory();
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [pageCount, setPageCount] = useState('');
    const [errors, setErrors] = useState({});
    const [serverError, setServerError] = useState(null);

    useEffect(() => {
        const fetchBook = async () => {
            try {
                const response = await axios.get(`/api/books/${id}`);
                const { title, author, pageCount } = response.data;
                setTitle(title);
                setAuthor(author);
                setPageCount(pageCount);
            } catch (err) {
                console.error(err);
            }
        };

        fetchBook();
    }, [id]);

    const validate = () => {
        const newErrors = {};
        if (title.length < 2) newErrors.title = "A book's title must be at least two characters long!";
        if (author.length < 5) newErrors.author = "An author's name must be at least five characters long!";
        if (!pageCount) newErrors.pageCount = "A book must have some pages!";
        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validate()) {
            try {
                await axios.put(`/api/books/${id}`, { title, author, pageCount });
                history.push('/');
            } catch (err) {
                setServerError(err.response.data);
            }
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                placeholder="Title"
            />
            {errors.title && <span>{errors.title}</span>}
            <input
                type="text"
                value={author}
                onChange={(e) => setAuthor(e.target.value)}
                placeholder="Author Name"
            />
            {errors.author && <span>{errors.author}</span>}
            <input
                type="number"
                value={pageCount}
                onChange={(e) => setPageCount(e.target.value)}
                placeholder="Page Count"
            />
            {errors.pageCount && <span>{errors.pageCount}</span>}
            <button type="submit" disabled={Object.keys(errors).length > 0}>
                Update Book!
            </button>
            {serverError && (
                <div>
                    <p>Error: {serverError.name} ({serverError.statusCode})</p>
                    <p>Message: {serverError.message}</p>
                    <div>
                        {Object.keys(serverError.validations).map((field) => (
                            <p key={field}>{field}: {serverError.validations[field]}</p>
                        ))}
                    </div>
                </div>
            )}
        </form>
    );
};

export default UpdateBook;
