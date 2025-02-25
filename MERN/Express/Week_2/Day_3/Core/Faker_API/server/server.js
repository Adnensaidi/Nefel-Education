import express from 'express';
import { faker } from '@faker-js/faker';

const app = express();
const port = 3000;

app.use(express.json());

const createUser = () => {
    const newUser = {
        _id: faker.string.uuid(),
        firstName: faker.person.firstName(),
        lastName: faker.person.lastName(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        password: faker.internet.password()
    };
    return newUser;
};

const createCompany = () => {
    const newCompany = {
        _id: faker.string.uuid(),
        name: faker.company.name(),
        address: {
            street: faker.location.street(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            country: faker.location.country()
        }
    };
    return newCompany;
};

app.get("/api/users/new", (req, res) => {
    const newUser = createUser();
    res.json(newUser);
});

app.get("/api/companies/new", (req, res) => {
    const newCompany = createCompany();
    res.json(newCompany);
});

app.get("/api/user/company", (req, res) => {
    const newUser = createUser();
    const newCompany = createCompany();
    res.json({
        user: newUser,
        company: newCompany
    });
});

app.listen(port, () => console.log(`Server running on port ${port}`));