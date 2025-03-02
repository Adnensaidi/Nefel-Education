import express from 'express'
import postRoutes from './routes/post.routes.js'
import dbConfig from './config/db.config.js'
import cors from 'cors'
import dotenv from "dotenv"

// declare an app
const app = express()

// cors
app.use(cors())
// app use json
app.use(express.json())

// app use routes
app.use("/api/posts",postRoutes)

//db connection invoked
dbConfig()

// to use process.env
dotenv.config()
const PORT=process.env.PORT

app.listen(PORT,()=>{
    console.log(`Server is running successfully on port ${PORT}`)
})