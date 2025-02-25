const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Book = require('./bookModel');

const app = express();
const port = 3000;

app.use(bodyParser.json());

    mongoose.connect('yourMongoDBURI', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('Connected to MongoDB'))
    .catch(err => console.error('Error connecting to MongoDB:', err));

    app.post('/books', async (req, res) => {
    const { title, author, pages, isAvailable } = req.body;
    try {
        const newBook = new Book({ title, author, pages, isAvailable });
        await newBook.save();
        res.status(201).json(newBook);
    } catch (err) {
        res.status(400).json({ error: err.message });
    }
    });

    app.get('/books', async (req, res) => {
    try {
        const books = await Book.find();
        res.status(200).json(books);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
    });

    app.get('/books/:id', async (req, res) => {
    try {
        const book = await Book.findById(req.params.id);
        if (!book) return res.status(404).json({ error: 'Book not found' });
        res.status(200).json(book);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
    });

    app.put('/books/:id', async (req, res) => {
    const { title, author, pages, isAvailable } = req.body;
    try {
        const updatedBook = await Book.findByIdAndUpdate(
        req.params.id,
        { title, author, pages, isAvailable },
        { new: true }
        );
        if (!updatedBook) return res.status(404).json({ error: 'Book not found' });
        res.status(200).json(updatedBook);
    } catch (err) {
        res.status(400).json({ error: err.message });
    }
    });

    app.delete('/books/:id', async (req, res) => {
    try {
        const deletedBook = await Book.findByIdAndDelete(req.params.id);
        if (!deletedBook) return res.status(404).json({ error: 'Book not found' });
        res.status(200).json({ message: 'Book deleted successfully' });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
    });

    app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
