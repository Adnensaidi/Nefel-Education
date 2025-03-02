import Book from "../models/Book.js";
const getAllBooks = async (req,res)=>{
    try {
        const books = await Book.find({});
        res.json(books);
    } catch (error) {
        console.log(error);
    }
}
const getBookById =async (req,res)=>{
    try {
        const book = await Book.findById(req.params.id);
        if(book){
            res.status(200).json(book)
        }else{
            res.status(404).json({message:'book not found'})
        }
    } catch (error) {
        console.log(error);
    }
}

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

const updateBook = async (req, res, next) => {
    try {
        const { id } = req.params;
        const { title, author, pageCount } = req.body;
        const book = await Book.findByIdAndUpdate(id, { title, author, pageCount }, { new: true, runValidators: true });
        if (!book) {
            const error = new Error('Book not found');
            error.statusCode = 404;
            throw error;
        }
        res.status(200).json(book);
    } catch (error) {
        next(error);
    }
};



const deleteBook = async(req,res)=>{
    try {
        const deletedBook = await Book.findByIdAndDelete(req.params.id);
        if(deletedBook){
            res.json({message:"book deleted"})
        }else{
            res.json({message:"not found"})
        }
    } catch (error) {
        console.log(error);
    }
}

module.exports = {
    createBook,
    updateBook,
};
export {deleteBook,updateBook,createBook,getBookById,getAllBooks};