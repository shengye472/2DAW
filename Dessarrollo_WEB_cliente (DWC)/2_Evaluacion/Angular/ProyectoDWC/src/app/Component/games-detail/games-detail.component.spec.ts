import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GamesDetailComponent } from './games-detail.component';

describe('GamesDetailComponent', () => {
  let component: GamesDetailComponent;
  let fixture: ComponentFixture<GamesDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GamesDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GamesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
