const Book = require('../models/book');

const createBook = async (req, res, next) => {
    try {
        const { title, author, pageCount } = req.body;
        const book = new Book({ title, author, pageCount });
        await book.save();
        res.status(201).json(book);
    } catch (error) {
        next(error);
    }
};

module.exports = {
    createBook,
};
