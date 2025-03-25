const errorHandler = (err, req, res, next) => {
    const normalizedError = {
        name: err.name || 'Error',
        statusCode: err.statusCode || 500,
        message: err.message || 'An unexpected error occurred',
        validations: err.validations || {},
    };
    res.status(normalizedError.statusCode).json(normalizedError);
};

const notFoundHandler = (req, res, next) => {
    const err = new Error('Not Found');
    err.statusCode = 404;
    next(err);
};

module.exports = {
    errorHandler,
    notFoundHandler,
};
