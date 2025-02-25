const mongoose = require('mongoose');

const bookSchema = new mongoose.Schema(
    {
        title: {
        type: String,
        required: [true, 'Title is required'],
        minlength: [2, 'Title must be at least 2 characters long'],
        maxlength: [255, 'Title must be less than 255 characters'],
        },
        author: {
        type: String,
        required: [true, 'Author is required'],
        minlength: [5, 'Author must be at least 5 characters long'],
        maxlength: [255, 'Author must be less than 255 characters'],
        },
        pages: {
        type: Number,
        required: [true, 'Number of pages is required'],
        min: [1, 'Number of pages must be at least 1'],
        },
        isAvailable: {
        type: Boolean,
        default: false,
        },
    },
    { timestamps: true }
);

const Book = mongoose.model('Book', bookSchema);

module.exports = Book;