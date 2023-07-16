import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css'],
})
export class FrontPageComponent implements OnInit {
  constructor(private route: Router) {}

  ngOnInit(): void {}
  images: any = [
    {
      img: 'https://en.wikipedia.org/wiki/Train#/media/File:%D0%9F%D0%BE%D0%B5%D0%B7%D0%B4_%D0%BD%D0%B0_%D1%84%D0%BE%D0%BD%D0%B5_%D0%B3%D0%BE%D1%80%D1%8B_%D0%A8%D0%B0%D1%82%D1%80%D0%B8%D1%89%D0%B5._%D0%92%D0%BE%D1%80%D0%BE%D0%BD%D0%B5%D0%B6%D1%81%D0%BA%D0%B0%D1%8F_%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C.jpg',
      desc: 'Apple Desktop',
    },
    {
      img: 'https://rukminim1.flixcart.com/image/832/832/l2p23rk0/mobile/s/4/3/-original-imagdznhcbdfwfud.jpeg?q=70',
      desc: 'Vivo Mobile',
    },
    {
      img: 'https://rukminim1.flixcart.com/image/832/832/xif0q/smart-headphone/y/b/m/liquid-earbuds-madrabbit-original-imagmzgye5rqqkeh.jpeg?q=70',
      desc: 'Boat Earpods',
    },
    {
      img: 'https://rukminim1.flixcart.com/image/832/832/xif0q/smartwatch/b/h/v/-original-imagkfm8rcrrjznb.jpeg?q=70',
      desc: 'Digital Watch',
    },
  ];

  onClick() {
    this.route.navigate(['/home']);
  }
}
