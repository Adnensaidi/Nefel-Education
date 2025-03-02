import mongoose from 'mongoose';

const postSchema = new mongoose.Schema({
    title: {
        type: String,
        required: [true, 'Title is required'],
        minlength: [5, 'Title must be at least 5 characters']
        },
        content: {
        type: String,
        required: [true, 'Content is required']
        },

        reviews: {
        type: [String],
        defaul:[]
        },
        like:{
            type:Number,
            default:0
        }
    }, {
        timestamps: true
    });

    const Post = mongoose.model('Post', postSchema);
export default Post;