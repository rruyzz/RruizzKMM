import SwiftUI
import shared
    
struct HomeSearch: View {
    var carousselMovie: [Movie]
    
    @State private var currentIndex = 0
    @State private var labelHeight = CGFloat.zero
    
    var body: some View {
        TabView {
            ForEach(carousselMovie, id: \.self) { image in
                CarousselImage(
                    carousselImage: image.backdropPath,
                    movieTitle: image.title
                )
                .frame(height: 200) 
                .cornerRadius(25)
                .padding(.horizontal, 10)
            }
        }
        .tabViewStyle(PageTabViewStyle())
        .frame(height: 220)
    }
}

struct CarousselImage: View {
    var carousselImage: String
    var movieTitle: String
    
    var body: some View {
        AsyncImage(url: URL(string: carousselImage)) { image in
            if image.image != nil {
                image.image!
                    .resizable()
                    .scaledToFill()
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .cornerRadius(25)
                    .clipped()
                    .overlay(
                        alignment: .topLeading,
                        content: {
                            HStack {
                                Text(movieTitle)
                                              .bold()
                                              .foregroundColor(Color.white)
                                              .padding()
                                              .background(Color.black.opacity(0.6)) // Título legível
                                              .cornerRadius(10)
                                              .padding(.leading, 20)
                            }
                        }
                    )
            } else if image.error != nil {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }.padding(.horizontal, 10)
    }
}
