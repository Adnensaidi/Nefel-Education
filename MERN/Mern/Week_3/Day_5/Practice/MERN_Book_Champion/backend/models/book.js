const mongoose = require('mongoose');

const bookSchema = new mongoose.Schema({
    title: { type: String, required: true, minlength: 2 },
    author: { type: String, required: true, minlength: 5 },
    pageCount: { type: Number, required: true },
});

const Book = mongoose.model('Book', bookSchema);

module.exports = Book;
