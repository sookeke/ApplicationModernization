import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Box, Card, CardActionArea, CardActions, CardContent, CardMedia, Button, Typography } from '@material-ui/core';
import { AddShoppingCart as AddShoppingCartIcon } from '@material-ui/icons';
const useStyles = makeStyles({
  root: {
    maxWidth: 345,
  },
  media: {
    height: 140,
  },
});

export default function Product({ name, description, image, price, addToCart }) {
  const classes = useStyles();

  return (
    <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          className={classes.media}
          image={image}
          title={name}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            {name}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            {description}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions disableSpacing>
        <Button size="small" color="primary" onClick={addToCart}>
          <AddShoppingCartIcon /> Add to Cart
        </Button>
        <Box style={{ marginLeft: 'auto' }}>
          <span><strong>${price}</strong></span>
        </Box>

      </CardActions>
    </Card>
  );
}
