import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { CartService } from '../services/cart.service';
// import { ProductService } from '../services/product.service';
import { StorageService } from '../services/storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private roles: string[];
  isLoggedIn = false;
  AddTrains = false;
  searchTrains = false;
  showTrain = false;
  delete = false;
  book = false;
  cancel = false;
  username: string;
  searchTerm:string ='';
  typeData!:any;
  clickCart:boolean = false;

  // constructor(private storageService:StorageService,
  //             private router:Router
  //             // private cartService:CartService,
  //             private productService:ProductService){

  // }
  constructor(
    private storageService: StorageService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.isLoggedIn = !!this.storageService.getToken();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.AddTrains = this.roles.includes('ROLE_ADMIN');
      this.showTrain = this.roles.includes('ROLE_ADMIN');
      this.delete = this.roles.includes('ROLE_ADMIN');
      this.searchTrains = this.roles.includes('ROLE_USER');
      this.book = this.roles.includes('ROLE_USER');
      this.cancel = this.roles.includes('ROLE_USER');

      this.username = user.username;
    }
  }

  onLogout(){
    this.storageService.signOut();
    alert('You have logged out successfully');
    this.router.navigate(['login']).then(()=>{
      window.location.reload();
    });
  }
  
  // search(event:any){
  //   this.searchTerm = (event.target as HTMLInputElement).value;
  //   console.log(this.searchTerm);
  //   // this.cartService.search.next(this.searchTerm);
  // }

  // filter(productType:any){
  //   this.productService.getProductsByType(productType).subscribe(data=>{
  //     console.log(data);
  //     this.productService.type.next(data);
  //   })   
  // }

  // getAll(){
  //   this.productService.getAllProduct().subscribe(data=>{
  //     console.log(data);
  //     this.productService.type.next(data);
  //   })
  // }

  // onClickCart(){
  //   this.clickCart = true;
  //   this.router.navigate(['/cart']);
  // }

  onClickElectronicShopping(){
    this.router.navigate(['/home']).then(()=>{
      window.location.reload();
    });
  }
}
