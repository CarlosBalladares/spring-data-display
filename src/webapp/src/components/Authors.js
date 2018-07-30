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

class Authors extends React.Component{
  constructor(){
    super();
    this.state={
      error: null,
      isLoaded: false,
      authors:[]
    }
  }

  componentDidMount() {
    const authors ={}
    fetch("/api/authors")
      .then(res => res.json())
      .then(
        (result) => {
          console.log(result);
          this.setState({
            isLoaded: true,
            authors: result._embedded.authors
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
    const {authors}=this.state;
    const {classes}= this.props;
    console.log(authors);
  return (
    <div>
    <Typography variant="display3">Authors</Typography>

    <Paper className={classes.root}>

      <Table>
        <TableHead>
          <TableCell> <Typography variant="title">First Name</Typography> </TableCell>
          <TableCell> <Typography variant="title">Last Name</Typography> </TableCell>

        </TableHead>
        {authors.map((item, id)=>(
            <TableRow>
              <TableCell>
                <Typography>{item.firstName}</Typography> 
              </TableCell>
              <TableCell>
                <Typography>{item.lastName}</Typography> 
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

export default withStyles(styles)(Authors);