import express from 'express';
import router from './routes/tv.routes.js';
const app = express();
const port = 8000;

app.use(express.json());

app.use("/api/tvShows", router)


app.listen(port, () => {
    console.log(`Listening on port ${port}`)
})