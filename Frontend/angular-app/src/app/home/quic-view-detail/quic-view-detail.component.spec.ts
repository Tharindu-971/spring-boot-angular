import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuicViewDetailComponent } from './quic-view-detail.component';

describe('QuicViewDetailComponent', () => {
  let component: QuicViewDetailComponent;
  let fixture: ComponentFixture<QuicViewDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuicViewDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuicViewDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
