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
                ).clipShape(.rect(cornerRadius: 25))
            }
        }
        .tabViewStyle(PageTabViewStyle())
        .frame(height: 200)
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
                    .scaledToFit()
//                    .scaledToFill()
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .clipped()
                    .cornerRadius(20)
                    .overlay(
                        alignment: .topLeading,
                        content: {
                            HStack {
                                Spacer().frame(width: 20)
                                Text(movieTitle)
                                    .bold()
                                    .foregroundColor(Color.white)
                                    .padding()
                            }
                        }
                    )
//                    .border(Color.blue)
            } else if image.error != nil {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }
        .clipShape(.rect(cornerRadius: 25))

    }
}
