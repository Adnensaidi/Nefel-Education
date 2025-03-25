import {Router} from "express"
import { createBook, deleteBook, getAllBooks, getBookById, updateBook } from "../controllers/book.controller.js";


const express = require('express');
const { createBook, updateBook } = require('../controllers/bookController');
const router = express.Router();

router.post('/', createBook);
router.put('/:id', updateBook);

module.exports = router;



export default bookRouter;