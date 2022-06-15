const express = require('express');
const app = express();
app.use(express.json());
const customers = [
 { title: 'Dharshini', id:22 },
 { title: 'Priyo', id:70 },
 { title: 'Juhi', id: 42 }
 ]
 //READ Request Handlers
app.get('/', (req, res) => {
 res.send('Welcome to Edurekas REST API with Node.js Tutorial!!');
});
app.get('/api/customers', (req, res) => {
 res.send(customers);
});
app.get('/api/customers/:id', (req, res) => {
 const customer = customers.find(c => c.id === parseInt(req.params.id));
 if (!customer) res.status(404).send(
 '<h2 style="font-family: Malgun Gothic; color: darkred;">\Ooops... Cant find what you are looking for!</h2>');
 res.send(customer);
});
//CREATE Request Handler
app.post('/api/customers', (req, res) => {

 const { error } = validatecustomer(req.body);
 if (error) {
 res.status(400).send(error.details[0].message)
 return;
 }
 const customer = {
 id: customers.length + 1,
 title: req.body.title
 };
 customers.push(customer);
 res.send(customer);
});
//UPDATE Request Handler
app.put('/api/customers/:id', (req, res) => {
 const customer = customers.find(c => c.id === parseInt(req.params.id));
 if (!customer) res.status(404).send(
 '<h2 style="font-family: Malgun Gothic; color: darkred;">Not Found!! </h2>');
 const { error } = validatecustomer(req.body);
 if (error) {
 res.status(400).send(error.details[0].message);
 return;
 }
 customer.title = req.body.title;
 res.send(customer);
});
//DELETE Request Handler
app.delete('/api/customers/:id', (req, res) => {
 const customer = customers.find(c => c.id === parseInt(req.params.id));
 if (!customer) res.status(404).send('<h2 style="font-family: Malgun Gothic; color: darkred;"> Not Found!! < /h2>');
 const index = customers.indexOf(customer);
 customers.splice(index, 1);
 res.send(customer);
});
function validatecustomer(customer) {
 const schema = {
 title: Joi.string().min(3).required()
 };
 return Joi.validate(customer, schema);
}
//PORT ENVIRONMENT VARIABLE
const port = process.env.PORT || 8080;
app.listen(port, () => console.log('Listening on port ${port}..'));