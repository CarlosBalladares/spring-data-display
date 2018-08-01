import React from 'react'
import { withStyles } from '@material-ui/core/styles';
import { Card, Typography, TextField, Button } from '@material-ui/core/'
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';


const styles ={
  root:{
    padding:50,
    display:'flex',
    'justify-content':'center',
    flex:1
  }
}


const Book={
  title:'SomeTitlw',
  isbn:'SomeTitlw',
  authors:[],
  publisher:{
    "name": "Harper Collins",
    "address": "SomeAddress",
  }

}

class Books extends React.Component{
  constructor(){
    super();
    this.state={
      error: null,
      isLoaded: false,
      books:[]
    }
  }

  componentDidMount() {
    
    fetch("/api/books")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            books: result._embedded.books
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render(){
    const {styles}=this.props;
    const {books}=this.state;
    const {classes}= this.props;
    console.log(books);
  return (
    <div>
    <Typography variant="display3">Books</Typography>

    <Paper className={classes.root}>
      <Table>
        <TableHead>
          <TableCell> <Typography variant="title">Book Title</Typography> </TableCell>
          <TableCell> <Typography variant="title">Book ISBN</Typography> </TableCell>

        </TableHead>
        {books.map((item, id)=>(
            <TableRow>
              <TableCell>
                <Typography>{item.title}</Typography> 
              </TableCell>
              <TableCell>
                <Typography>{item.isbn}</Typography> 
              </TableCell>
            </TableRow>
          ) 
        )}
      </Table>
      
    </Paper>
    
    </div>
   

    
  
    );
  }

}

export default withStyles(styles)(Books);